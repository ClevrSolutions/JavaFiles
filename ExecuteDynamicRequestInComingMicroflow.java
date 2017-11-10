// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mendix.actions;

import com.mendix.core.Core;
import com.mendix.core.CoreException;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.systemwideinterfaces.core.IFeedback.MessageType;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;

public class ExecuteDynamicRequestInComingMicroflow extends CustomJavaAction<java.lang.Boolean>
{
	private IMendixObject __RequestPar;
	private process.proxies.Request RequestPar;
	private java.lang.String MicroflowName;
	private IMendixObject __incomingMessage;
	private interfaceshared.proxies.IncomingMessage incomingMessage;

	public ExecuteDynamicRequestInComingMicroflow(IContext context, IMendixObject RequestPar, java.lang.String MicroflowName, IMendixObject incomingMessage)
	{
		super(context);
		this.__RequestPar = RequestPar;
		this.MicroflowName = MicroflowName;
		this.__incomingMessage = incomingMessage;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.RequestPar = __RequestPar == null ? null : process.proxies.Request.initialize(getContext(), __RequestPar);

		this.incomingMessage = __incomingMessage == null ? null : interfaceshared.proxies.IncomingMessage.initialize(getContext(), __incomingMessage);

		// BEGIN USER CODE
		
		//invoke the microflow
		try {
			//object arguments Request and incoming message both available
			if (incomingMessage != null && RequestPar != null) {
				Core.execute(getContext(), MicroflowName, RequestPar.getMendixObject().getId(),incomingMessage.getMendixObject().getId());
			}
			//object arguments incoming message available but no request available in case of create new request
			if (incomingMessage != null && RequestPar == null){
				Core.execute(getContext(), MicroflowName, incomingMessage.getMendixObject().getId());
				}				
			//object arguments Request and incoming message both NOT available
			if(incomingMessage == null && RequestPar == null) {
				Core.execute(getContext(), MicroflowName);
			}
		} catch (CoreException e) {
			this.addTextMessageFeedback(MessageType.WARNING, "Failed to execute dynamic request microflow " + MicroflowName + ", check the log for details", false);
			Core.getLogger("Interface").error("Failed to execute dynamic request microflow " + MicroflowName, e);
			return false;
		}
		
		return true;

		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public java.lang.String toString()
	{
		return "ExecuteDynamicRequestInComingMicroflow";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
