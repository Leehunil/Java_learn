package ch13;

import java.util.Comparator;

public class Member implements Comparator<Member>/*Comparable<Member>*/{

	private int memberId;
	private String memberName;
	
	public Member() {}
	
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
	
	//Comparable
	/*
	@Override
	public int compareTo(Member member) {
	//내가 호출하지 않고 시스템이 호출시켜주어서 내자신의 아이디와 비교한다.
	//내꺼와 넘어온 argument를 비교를 해서 내것이 더큰경우 양수,같으면 0,작으면 음수 반환
		if(this.memberId > member.memberId) {
			return 1;
		}
		else if(this.memberId < member.memberId) {
			return -1;
		}
		else return 0;
		//더 간다한 코드
		return (this.memberId - member.memberId);
	}
	*/	
	//comparator
	@Override
	public int compare(Member member1, Member member2) {
		//comparator는 argument가 2개가 넘어와 이 2개를 비교해야한다.
		return (member1.memberId-member2.memberId);
	}
	
	
}


package ch13;

import java.util.Iterator;
import java.util.TreeSet;

public class MemberTreeSet {
	
	private TreeSet<Member> treeSet;
	
	public MemberTreeSet() {
		treeSet = new TreeSet<Member>(new Member());
	}
	//comparator일 경우 Comparator가 구현할 것을 지정해주어야한다.

	public void addMember(Member member) {
		treeSet.add(member);
	}
	
	public boolean removeMember(int memberId) {

		Iterator<Member> ir = treeSet.iterator();
		
		while(ir.hasNext()) {

			Member member = ir.next();
			
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				treeSet.remove(member);
				return true;
			}
		}
		System.out.println("No exit this Id");
		return false;
	}
	
	public void showAllMember() {
		for(Member member:treeSet) {
			System.out.println(member);
		}
		System.out.println();
	}
}



package ch13;

public class MemberTreeSetTest {

	public static void main(String[] args) {

		MemberTreeSet memberTreeSet =new MemberTreeSet();
		
		Member memberLee = new Member(1001,"Leehunil");
		Member memberJoe = new Member(1002,"Joejunjang");
		Member memberKim = new Member(1003,"Kimchanwoo");
		Member memberSong = new Member(1004,"Songsinhyung");
		
		memberTreeSet.addMember(memberLee);
		memberTreeSet.addMember(memberJoe);
		memberTreeSet.addMember(memberKim);
		memberTreeSet.addMember(memberSong);
		
		memberTreeSet.showAllMember();
	}

}
