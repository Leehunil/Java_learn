package ch12;

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


package ch12;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
//중복이 되지 않게 자료를 관리하는 Set 인터페이스
	
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<>();
	}
	
	public MemberHashSet(int size) {
		hashSet = new HashSet<>(size);
	}

	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	public boolean removeMember(int memberId) {

		Iterator<Member> ir = hashSet.iterator();
		
		while(ir.hasNext()) {

			Member member = ir.next();
			
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		System.out.println("No exit this Id");
		return false;
	}
	
	public void showAllMember() {
		for(Member member:hashSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}



package ch12;

public class MemberHashSetTest {

	public static void main(String[] args) {

		MemberHashSet memberHashSet =new MemberHashSet();
		
		Member memberLee = new Member(1001,"Leehunil");
		Member memberJoe = new Member(1002,"Joejunjang");
		Member memberKim = new Member(1003,"Kimchanwoo");
		
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberJoe);
		memberHashSet.addMember(memberKim);
		
		Member memberSong = new Member(1003,"Songsinhyung");
		memberHashSet.addMember(memberSong);
		
		memberHashSet.showAllMember();
		//1003이 같기 때문에 memberSong은 출력이 되지 않는다.
	}

}
