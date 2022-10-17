package program.chatting.model;

public class MemberFriend {
    
    public interface Entity {
        String TBL_MEMBER_FRIEND            = "MEMBER_FRIEND";
        String COL_MEMBER_NO_MEMBER_FRIEND  = "MEMBER_NO";
        String COL_FRIEND_NO_MEMBER_FRIEND  = "FRIEND_NO"; 
    }
    
    private int member_friend;
    private int member_no;
    private int friend_no;
    
    public MemberFriend() {};
    
    public MemberFriend(int member_friend, int member_no, int friend_no) {
        this.member_friend = member_friend;
        this.member_no = member_no;
        this.friend_no = friend_no;
    }

    public int getMember_friend() {
        return member_friend;
    }

    public int getMember_no() {
        return member_no;
    }

    public int getFriend_no() {
        return friend_no;
    }
    
}
