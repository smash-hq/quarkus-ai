package cc.smash.learning.agent;

import cc.smash.learning.dto.TravelDTO;
import cc.smash.learning.tools.Weather;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;


@RegisterAiService(tools = Weather.class)
public interface TravelAgent {

    // 能力一：负责陪用户聊天、写攻略
    @SystemMessage("你是一个热情、专业的旅游规划师，请根据用户的旅游想法，提供出发地与目的地，提供旅游建议，美食，以及提供住宿、行车信息，总共花费。")
    String chat(String userQuestion);

    // 能力二：负责根据上面生成的回答，把数据抠出来变成结构体
    @SystemMessage("你是一个后台数据审计员，你的任务是阅读一段旅游规划师的回复文本，从中提炼出最终推荐的旅游要素。")
    @UserMessage("请分析以下旅游规划师的回复，严格提取出旅游意向结构体：{aiResponseText}")
    TravelDTO extract(String aiResponseText);
}
