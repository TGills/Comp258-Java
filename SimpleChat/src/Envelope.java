/*
 * @author guillaume2127
 */
public class Envelope {
       
  private String recipient;
  private Object contents;
  
  public Envelope(){}
  
  public Envelope(String recipeient, Object contents){
      setRecipient(recipeient);
      setContents(contents);     
  }  
    /**
     * @return the recipient
     */
    public String getRecipient() {
        return recipient;
    }
    /**
     * @param recipient the recipient to set
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    /**
     * @return the contents
     */
    public Object getContents() {
        return contents;
    }
    /**
     * @param contents the contents to set
     */
    public void setContents(Object contents) {
        this.contents = contents;
    }   
     
}