package ch14;

public class Member {

	private int memberId;
	private String memberName;
	
	public Member(int memberId,String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public int hashCode() {
		return memberId;
	}
	
	//동일한 값은 add하지 못하게 하려면 equals를 직접 구현해야 한다.
	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Member) {
			
			Member member= (Member)obj;
			if(this.memberId ==member.memberId) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public String toString() {
		return memberName + "'s member Id is "+memberId;
	}
	
	
}


package ch14;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

	private HashMap<Integer, Member> hashMap;
	//key:Integer ,value: Member
	
	public MemberHashMap() {
		hashMap = new HashMap<>();
	}
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	
	public boolean removeMember(int memberId){
		//containsKey(key): hashMap에 key값이 있는지 확인
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return true;
		}
		System.out.println("No element");
		return false;
	}
	
	public void showAll() {
		//hashMap을 Iterator로 만들어주고
		Iterator<Integer> ir = hashMap.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();               // key값을 하나씩 받는다.
			Member member = hashMap.get(key);  // 그 key값에 value값을 member에 받고
			System.out.println(member);        // 출력
		}
	}
}


package ch14;

import java.util.HashMap;

public class MemberHashMapTest {

	public static void main(String[] args) {

		MemberHashMap memberHashMap =new MemberHashMap();
		
		Member memberLee = new Member(1001,"Leehunil");
		Member memberJoe = new Member(1002,"Joejunjang");
		Member memberKim = new Member(1003,"Kimchanwoo");
		Member memberSong = new Member(1004,"Songsinhyung");
		
		memberHashMap.addMember(memberLee);
		memberHashMap.addMember(memberJoe);
		memberHashMap.addMember(memberKim);
		memberHashMap.addMember(memberSong);
		
		memberHashMap.showAll();
		
		HashMap<Integer,String> hashMap = new HashMap<>();
		hashMap.put(1001, "Lee");
		hashMap.put(1002, "Kim");
		hashMap.put(1003, "Chan");
		hashMap.put(1004, "jun");
		
		System.out.println(hashMap);
		//key=value 페어로 출력된다.
	}

}
