// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sdemigration.actions;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import scala.Console;
import sun.misc.UUDecoder;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

public class UUEncodeToFile extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String uuencodeString;
	private IMendixObject __Filedocument;
	private system.proxies.FileDocument Filedocument;

	public UUEncodeToFile(IContext context, java.lang.String uuencodeString, IMendixObject Filedocument)
	{
		super(context);
		this.uuencodeString = uuencodeString;
		this.__Filedocument = Filedocument;
	}

	@Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.Filedocument = __Filedocument == null ? null : system.proxies.FileDocument.initialize(getContext(), __Filedocument);

		// BEGIN USER CODE
		if (Filedocument == null)
			throw new IllegalArgumentException("Destination file is null");
		if (uuencodeString == null)
			throw new IllegalArgumentException("Value to write is null");
		
	      try {
	          UUDecoder uudc = new UUDecoder();       
	          byte[] decodedBytes = uudc.decodeBuffer(uuencodeString);
	          ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
	          
	          Core.storeFileDocumentContent(getContext(), Filedocument.getMendixObject(),bis);
	
	              
	       } catch (IOException e) {
	    	  Core.getLogger("UUEncodeToFile").error(e.toString());
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
		return "UUEncodeToFile";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
