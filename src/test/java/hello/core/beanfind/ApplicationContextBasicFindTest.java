package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;

class ApplicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
//		System.out.println("memberService = " + memberService);
//		System.out.println("memberService.getClass() = " + memberService.getClass());
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("빈 타입으로 조회")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("구체 타입으로 조회")
	void findBeanByNam2e() {
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("빈 이름으로 조회X")
	void findBeanByNameX() {
//		MemberService memberService = ac.getBean("xxxx", MemberService.class);
		Assertions.assertThrows(NoSuchBeanDefinitionException.class,
				() -> ac.getBean("xxxx", MemberService.class));
	}
	
}