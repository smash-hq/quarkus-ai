package cc.smash.learning.agent;


import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

/**
 * 创建时间：2026/5/15 14:34
 *
 * @author smash_hq
 * @description 受众作者
 */
public interface AudienceEditor {
    @UserMessage("""
            You are a professional editor.
            Analyze and rewrite the following story to better align
            with the target audience of {{audience}}.
            Return only the story and nothing else.
            The story is "{{story}}".
            """)
    @Agent("Edits a story to better fit a given audience")
    String editStory(@V("story") String story, @V("audience") String audience);
}
