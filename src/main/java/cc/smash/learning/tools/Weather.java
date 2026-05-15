package cc.smash.learning.tools;


import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * 创建时间：2026/5/15 10:50
 *
 * @author smash_hq
 * @description 获取天气
 */

@ApplicationScoped
public class Weather {

    @Tool("查询指定城市的实时天气情况")
    public String fetchWeather(String city) {
        // 这里模拟 API 调用，实际开发中你可以写 RestClient 调用天气接口
        if (city.contains("成都")) {
            return "成都今天阴转小雨，气温 18°C - 24°C，建议备好雨具。";
        } else if (city.contains("广州")) {
            return "广州今天多云，气温 28°C - 33°C，天气较热。";
        }
        return city + "天气晴朗，气温 25°C。";
    }
}
