package annoyance;

import static java.util.Collections.singletonMap;
import static java.util.stream.Collectors.toList;
import static org.fest.assertions.api.Assertions.assertThat;

import annoyance.model.Schedule;

import org.junit.Test;

public class NagTest {

    @Test
    public void withMention() {
        final String env = "daily:owner/repo/template.md:owner/repo/stuff/{date}/{week}.md:@chids";
        final Nag worker = new Nag(Schedule.daily, singletonMap("mock", env));
        assertThat(worker.tasks().collect(toList())).hasSize(1);
    }

    @Test
    public void withoutMention() {
        final String env = "daily:owner/repo/template.md:owner/repo/stuff/{date}/{week}.md";
        final Nag worker = new Nag(Schedule.daily, singletonMap("mock", env));
        assertThat(worker.tasks().collect(toList())).hasSize(1);
    }
}
