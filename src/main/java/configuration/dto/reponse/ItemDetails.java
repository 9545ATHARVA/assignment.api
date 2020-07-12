package configuration.dto.reponse;

public class ItemDetails {

    private String badge_type;
    private Integer award_count;
    private String rank;
    private Integer badge_id;
    private String link;
    private String name;

    public void setBadge_type(String badge_type) {
        this.badge_type = badge_type;
    }

    public void setAward_count(Integer award_count) {
        this.award_count = award_count;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setBadge_id(Integer badge_id) {
        this.badge_id = badge_id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemDetails() {
    }

    public String getBadge_type() {
        return badge_type;
    }

    public Integer getAward_count() {
        return award_count;
    }

    public String getRank() {
        return rank;
    }

    public Integer getBadge_id() {
        return badge_id;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }
//    {
//        "badge_type": "tag_based",
//            "award_count": 122,
//            "rank": "gold",
//            "badge_id": 123,
//            "link": "https://stackoverflow.com/badges/123/mysql",
//            "name": "mysql"
//    }
}
