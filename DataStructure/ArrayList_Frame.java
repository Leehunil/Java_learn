package ch10;

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


package ch10;

import java.util.ArrayList;

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
		for(int i=0;i<arrayList.size();i++) {
			Member member = arrayList.get(i);
			int tempId=member.getMemberId();
			if(tempId == memberId) {
				arrayList.remove(i);
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



package ch10;

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
