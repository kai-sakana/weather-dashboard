package com.example.demo.config;

import com.example.demo.entity.DailyWeather;
import com.example.demo.entity.HourlyWeather;
import com.example.demo.repository.DailyWeatherRepository;
import com.example.demo.repository.HourlyWeatherRepository;
import java.time.LocalDate;

//@Component // @を追加し、publicの綴りを修正
public class DataInitializer {

    public DataInitializer(
        DailyWeatherRepository dailyRepo,
        HourlyWeatherRepository hourlyRepo
    ) {
        LocalDate today = LocalDate.now();

        DailyWeather dailyData = new DailyWeather();
        dailyData.setAreaCode("TOKYO");
        dailyData.setDate(today.plusDays(1));
        dailyData.setTime("12:00"); // ★新しく追加した時刻をセット
        dailyData.setWeatherType("SUNNY");
        dailyData.setMaxTemp(13);
        dailyData.setMinTemp(7);
        
        dailyRepo.save(dailyData);

        for (int h = 9; h <= 18; h++) {
            // 1. まず空のオブジェクトを作る
            HourlyWeather hw = new HourlyWeather();
            
            // 2. 1つずつ値をセットする（Entityのメソッド名に合わせてください）
            hw.setAreaCode("TOKYO");
            hw.setDate(today);
            hw.setTime(h + ":00");    // intのhを "9:00" のような形式にする
            hw.setWeather("CLOUDY");
            hw.setTemp(10 + (h % 3));
            hw.setPop(20);            // 降水確率もいれておく
            
            // 3. 保存する
            hourlyRepo.save(hw);
        }
    }
}
