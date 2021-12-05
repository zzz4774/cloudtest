import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.AvailabilityZone;


public class AvailableZones {
	
	public static void availableZone(AmazonEC2 ec2)
	{
		DescribeAvailabilityZonesResult zones_response = ec2.describeAvailabilityZones();
			for(AvailabilityZone zone : zones_response.getAvailabilityZones()) {
			    System.out.printf(
			        "List zone %s " +
			        "with status %s " +
			        "in region %s \n",
			        zone.getZoneName(),
			        zone.getState(),
			        zone.getRegionName());
			}
		System.out.println("List Success");
	}
}
