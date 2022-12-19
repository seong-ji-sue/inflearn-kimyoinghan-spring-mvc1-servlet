package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용고려
 * 싱글톤으로 만들기
 * 아직 스프링 안쓰고 있어서 private로 막고 get으로만 조회되게 하기
 */
public class MemberRepository {


    //딱 1개만 생성
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;// 아이디 하나씩 증가 용도

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {

    }

    //Member 저장
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //Member 단일 조회
    public Member findById(Long id) {
        return store.get(id);
    }

    //Member 다중 조회
    //밖에서 Array를 조작해도 store는 조작하고 싶지 않아서
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //Member 전체 삭제
    public void clearStore() {
        store.clear();
    }
}
