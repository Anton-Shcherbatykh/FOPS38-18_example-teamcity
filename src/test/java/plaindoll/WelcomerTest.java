package plaindoll;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

public class WelcomerTest {
	
	private Welcomer welcomer = new Welcomer();
	// Если хочешь больше веселья и информации про ДевОпс - приходи в мои каналы NotOps (telegram, YT, Boosty, Patreon)
	// https://t.me/notopsofficial

	@Test
	public void welcomerSaysWelcome() {
		assertThat(welcomer.sayWelcome(), containsString("Welcome"));
	}
	
	@Test
	public void welcomerSaysFarewell() {
		assertThat(welcomer.sayFarewell(), containsString("Farewell"));
	}
	
	@Test
	public void welcomerSaysHunter() {
		assertThat(welcomer.sayWelcome(), containsString("hunter"));
		assertThat(welcomer.sayFarewell(), containsString("hunter"));
	}
	
	@Test
	public void welcomerSaysSilver(){
		assertThat(welcomer.sayNeedGold(), containsString("gold"));
	}
	
	@Test
	public void welcomerSaysSomething(){
		assertThat(welcomer.saySome(), containsString("something"));
	}
	
	@Test
	public void welcomerGetHunterReplyContainsHunter() {
		// Проверяем несколько раз, так как метод возвращает случайную реплику
		for (int i = 0; i < 50; i++) {
			String reply = welcomer.getHunterReply();
			assertNotNull("Реплика не должна быть null", reply);
			assertThat(reply.toLowerCase(), containsString("hunter"));
		}
	}
	
	@Test
	public void welcomerGetHunterReplyIsRandom() {
		// Проверяем, что метод возвращает разные реплики
		String firstReply = welcomer.getHunterReply();
		boolean hasDifferentReply = false;
		
		for (int i = 0; i < 20; i++) {
			if (!welcomer.getHunterReply().equals(firstReply)) {
				hasDifferentReply = true;
				break;
			}
		}
		
		assertTrue("Метод должен возвращать разные реплики", hasDifferentReply);
	}
}