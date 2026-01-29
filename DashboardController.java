package com.example.demo.controller;

import com.example.demo.service.ForecastService;
import com.example.demo.service.TodayService;
import com.example.demo.service.api.TrainService;

import org.springframework.stereotype.Controller; // RestControllerではなくControllerを使う
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // ここを @Controller に修正（画面を返すためのアノテーション）
public class DashboardController {

    private final TodayService todayService;
    private final ForecastService forecastService;
    private final TrainService trainService;
    private String selectedArea = "Tokyo";
    private String selectedMode = "Dark";

    public DashboardController(TodayService todayService, ForecastService forecastService, TrainService trainService) {
        this.todayService = todayService;
        this.forecastService = forecastService;
        this.trainService = trainService;
    }

    @GetMapping("/")
    public String dashboard(Model model) {
        // 今日の天気情報を取得して、HTML（dashboard.html）に渡す準備をする
        model.addAttribute("today", todayService.getTodayWeather(selectedArea));
        model.addAttribute("forecastList", forecastService.getNextThreeDaysForecast(selectedArea));
        model.addAttribute("highlight", todayService.getTodayHighlight(selectedArea));
        model.addAttribute("hourlyList", forecastService.getNextSevenHours(selectedArea));
        model.addAttribute("sun", todayService.getSunInfo(selectedArea));
        model.addAttribute("hourlyList", todayService.getHourlyWeather(selectedArea));
        model.addAttribute("sun", todayService.getSunInfo(selectedArea));

        model.addAttribute("mode", selectedMode);
        model.addAttribute("area", selectedArea);

       



        
        // src/main/resources/templates/dashboard.html を表示しに行く
        return "dashboard"; 
    }

    @GetMapping("/stats")
    public String statsPage(Model model) {
        // 予報サービスから時間ごとの予報データを取得してHTMLに渡す
        // ※ダッシュボードと同じデータを使います
        model.addAttribute("hourlyList", forecastService.getNextSevenHours(selectedArea));
        model.addAttribute("mode", selectedMode);
        model.addAttribute("area", selectedArea);
        
        return "stats"; // stats.html を表示
    }

    @GetMapping("/train")
    public String trainPage(Model model) {
        // 1. 実際の運行情報を取得（API連携）
        model.addAttribute("troubledLines", trainService.getRealTimeTroubledLines());
        
        // 2. 天気予報からタイムラインを生成（実データ連動）
        model.addAttribute("timeline", forecastService.generateImpactTimeline(selectedArea));
        model.addAttribute("mode", selectedMode);
        model.addAttribute("area", selectedArea);
        
        return "train";
    }

    @GetMapping("/settings")
public String settingsPage(Model model) {
    model.addAttribute("currentArea", selectedArea);
    model.addAttribute("currentMode", selectedMode);
    model.addAttribute("mode", selectedMode);
    model.addAttribute("area", selectedArea);
    return "settings"; // settings.htmlを表示
}

// --- 決定ボタンの処理 ---
@PostMapping("/settings/save")
public String saveSettings(@RequestParam(value = "area", required = false) String area,
                           @RequestParam(value = "mode", required = false) String mode) {
    // 選択された値を保持（本来はデータベースやセッションに保存します）
    if (area != null) this.selectedArea = area;
    if (mode != null) this.selectedMode = mode;
    
    System.out.println("Saved Area: " + selectedArea + ", Mode: " + selectedMode);

    // 保存後はダッシュボード（ホーム）へリダイレクト
    return "redirect:/";
}
}
