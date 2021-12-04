import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.Image;
import java.util.List;

public class ListImages {

	public static  void listImages(AmazonEC2 ec2)
	{
		DescribeImagesRequest request = new DescribeImagesRequest();
		DescribeImagesResult response = ec2.describeImages(request);
		System.out.println("list images");
		List<Image> images = response.getImages();

	    if (images.isEmpty()) {
	    	System.out.println("Empty Image");
	    }
	    else
	    {
	    	for(Image image:images)
	    	
	    	System.out.println(image.getImageId());
	    	System.out.println("\n");
	    }
		System.out.println("Complete");
	}
}
