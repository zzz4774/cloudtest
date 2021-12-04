import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;



public class ListInstance {

	public static void listInstance(AmazonEC2 ec2)
	{
		boolean finish_instance=false;
		
		DescribeInstancesRequest request= new DescribeInstancesRequest();
		
		while(!finish_instance)
		{
			DescribeInstancesResult response = ec2.describeInstances(request);
			
			for(Reservation reservation: response.getReservations())
			{
				for(Instance instance: reservation.getInstances())
				{
					System.out.printf(
							"Found instance with id %s, " +
							"Image ID %s, "+
						    "Instance Type %s, " +
							"state %b " +
						    "and monitoring state %b\n",
							instance.getInstanceId(),
							instance.getImageId(),
							instance.getInstanceType(),
							instance.getState(),
							instance.getMonitoring().getState()
							);
				}
			}
			
			request.setNextToken(response.getNextToken());
			
			if(response.getNextToken()==null)
			{
				finish_instance=true;
			}
				
		}
		
	}
}
