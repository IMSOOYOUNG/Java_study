package program.chatting.model;

public class MemberFriend {
    
    public interface Entity {
        String TBL_MEMBER_FRIEND            = "MEMBER_FRIEND";
        String COL_MEMBER_NICKNAME          = "MEMBER_NICKNAME";
        String COL_MEMBER_FRIEND_NICKNAME   = "MEMBER_FRIEND_NICKNAME"; 
    }
    
    private String member_nickname;
    private String member_friend_nickname;
    
    public MemberFriend() {}

    public MemberFriend(String member_nickname, String member_friend_nickname) {
        this.member_nickname = member_nickname;
        this.member_friend_nickname = member_friend_nickname;
    }

    public String getMember_nickname() {
        return member_nickname;
    }

    public String getMember_friend_nickname() {
        return member_friend_nickname;
    }

}
