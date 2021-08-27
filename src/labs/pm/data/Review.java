package labs.pm.data;

public class Review{
	private Rating rating;
	private String comments;
	
	public Review(Rating rating,String comments){
		this.rating = rating;
		this.comments = comments;
	}
	
	public Rating getRating(){
		return this.rating;
	}
	
	public String getComments(){
		return this.comments;
	}
	
	@Override
	public String toString(){
		return "Review(rating "+rating+", comments "+comments+")";
	}
}