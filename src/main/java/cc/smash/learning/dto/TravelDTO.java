package cc.smash.learning.dto;

import dev.langchain4j.model.output.structured.Description;

public class TravelDTO {

    @Description("出发城市，例如：北京、上海。必须提取城市名称")
    public String fromCity;

    @Description("目的城市，例如：成都、深圳")
    public String toCity;

    @Description("出行的具体日期，格式必须为 yyyy-MM-dd。如果用户没说年份，默认系统当前年份2026年。如果完全没提日期，则默认为当天")
    public String travelDate;

    @Description("天气情况，例如：成都：阴转小雨，18°C-24°C")
    public String weather;

    @Description("游玩景点，将推荐游玩景点提取到数组中,只取排名靠前的景点")
    public String[] sights;

    @Description("出行天数，纯数字。如果用户没说，返回 null")
    public Integer days;

    @Description("预算范围，例如：5000以内、1000-3000")
    public String budget;

    @Description("同行人员类型，例如：独自、情侣、家庭、朋友。如果用户没说，默认为独自")
    public String companions;

    @Description("交通方式偏好，例如：飞机、高铁、自驾。如果用户没说默认使用推荐的工具")
    public String transportMode;
}
