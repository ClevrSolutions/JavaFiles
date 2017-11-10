// This file was generated by Mendix Business Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package usermenu.actions;

import com.mendix.systemwideinterfaces.core.IFeedback;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

/**
 * v1.0: First version
 * -Opens form in-content based on input string. Input string needs to be formatted using the following format:
 * <Mendix module name> + ' /' + <Mendix Form Name> + '.mxf'
 * 
 * -Notes:
 * -->Only opens form that do not require a context object (use only forms that can be accessed from navigation)
 * 
 * 
 * 
 */
public class UU95_OpenAnyFormInContent extends CustomJavaAction<Boolean>
{
	private String MendixFormString;

	public UU95_OpenAnyFormInContent(IContext context, String MendixFormString)
	{
		super(context);
		this.MendixFormString = MendixFormString;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		// BEGIN USER CODE
		addOpenFormFeedback(MendixFormString, IFeedback.FormTarget.CONTENT);
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "OpenAnyFormInContent";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
