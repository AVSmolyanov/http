import com.fasterxml.jackson.annotation.JsonProperty;

public class Cat {
    private String id; // уникальный идентификатор записи
    private String text;  // сообщение
    private String type;  // тип животного
    private String user;  // имя пользователя
    private String upvotes; // голоса

    public Cat(@JsonProperty("id")String id, @JsonProperty("text")String text, @JsonProperty("type")String type, @JsonProperty("user")String user, @JsonProperty("upvotes")String upvotes){
        this.setId(id);
        this.setText(text);
        this.setType(type);
        this.setUser(user);
        this.setUpvotes(upvotes);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }



    @Override
    public  String toString(){
        return (id+" "+text+" "+type+" "+user+" "+upvotes);
    }


}
