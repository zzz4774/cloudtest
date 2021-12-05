import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.AccountAttributeValue;
import com.amazonaws.services.ec2.model.DescribeAccountAttributesResult;
import com.amazonaws.services.ec2.model.AccountAttribute;
import java.util.List;
import java.util.ListIterator;

public class DescribeAccounts {
	
	
	public static void describeAccounts(AmazonEC2 ec2)
	{
		try{
		    DescribeAccountAttributesResult accountResults = ec2.describeAccountAttributes();
		    List<AccountAttribute> accountList = accountResults.getAccountAttributes();
		    for (ListIterator iter = accountList.listIterator(); iter.hasNext(); ) {
		        AccountAttribute attribute = (AccountAttribute) iter.next();
		        System.out.print("\n Attribute name : "+attribute.getAttributeName());
		        List<AccountAttributeValue> values = attribute.getAttributeValues();

		        for (ListIterator iterVals = values.listIterator(); iterVals.hasNext(); ) {
		            AccountAttributeValue myValue = (AccountAttributeValue) iterVals.next();
		            System.out.print("\n Value : "+myValue.getAttributeValue());
		        }
		    }
		    System.out.print("Complete");
		}
		catch (Exception e)
		{
		    e.getStackTrace();
		}
	}
}
