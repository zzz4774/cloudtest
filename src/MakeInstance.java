import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

import java.util.Scanner;


public class MakeInstance {
	
	public static void makeInstance(AmazonEC2 ec2)
	{
		System.out.println("Put AMI ID :");
		Scanner ami=new Scanner(System.in);

		String ami_id;
		ami_id=ami.nextLine();
		RunInstancesRequest run_request=new RunInstancesRequest().withImageId(ami_id).withInstanceType(InstanceType.T2Micro).withMaxCount(1).withMinCount(1);
		RunInstancesResult run_response=ec2.runInstances(run_request);
		String reservation_id=run_response.getReservation().getInstances().get(0).getInstanceId();
		System.out.println(reservation_id);

	}

}
