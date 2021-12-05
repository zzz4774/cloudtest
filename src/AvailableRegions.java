import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Region;

public class AvailableRegions {

	public static void availableRegions(AmazonEC2 ec2)
	{
		DescribeRegionsResult regions_response = ec2.describeRegions();
		for(Region region : regions_response.getRegions()) {
		    System.out.printf(
		        "List region %s " +
		        "with endpoint %s \n",
		        region.getRegionName(),
		        region.getEndpoint());
		}
		System.out.println("List Success");
	}
}
