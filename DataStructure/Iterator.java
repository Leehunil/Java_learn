package ch11;

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
	public String toString() {
		return memberName + "'s member Id is "+memberId;
	}
	
	
}


package ch11;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberArrayList {

	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}
	
	public MemberArrayList(int size) {
		arrayList = new ArrayList<>(size);
	}

	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberId) {

		//Iterator
		Iterator<Member> ir = arrayList.iterator();
		
		while(ir.hasNext()) {
		//hasnext() 그다음이 있는지 확인, 있으면 true 없으면 false	
			Member member = ir.next();
			
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				arrayList.remove(member);
				return true;
			}
		}
		System.out.println("No exit this Id");
		return false;
	}
	
	public void showAllMember() {
		for(Member member:arrayList) {
			System.out.println(member);
		}
		System.out.println();
	}
}



package ch11;

public class MemberArrayListTest {

	public static void main(String[] args) {

		MemberArrayList memberArrayList =new MemberArrayList();
		
		Member memberLee = new Member(1001,"Leehunil");
		Member memberJoe = new Member(1001,"Joejunjang");
		Member memberKim = new Member(1001,"Kimchanwoo");
		Member memberSong = new Member(1001,"Songsinhyung");
		
		memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberJoe);
		memberArrayList.addMember(memberKim);
		memberArrayList.addMember(memberSong);
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(memberKim.getMemberId());
		memberArrayList.showAllMember();
	}

}
