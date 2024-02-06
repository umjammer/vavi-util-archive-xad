package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * *<br>
 *    client related stuff                                               *<br>
 *                                                                       *<br>
 * **********************************************************************<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:741</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadClient extends Structure {
	/** C type : xadClient* */
	public xadClient.ByReference xc_Next;
	/**
	 * set to XADCLIENT_VERSION<br>
	 * C type : xadUINT16
	 */
	public short xc_Version;
	/** C type : xadUINT16 */
	public short xc_MasterVersion;
	/** C type : xadUINT16 */
	public short xc_ClientVersion;
	/** C type : xadUINT16 */
	public short xc_ClientRevision;
	/**
	 * needed size to recog the type<br>
	 * C type : xadSize
	 */
	public long xc_RecogSize;
	/**
	 * see XADCF_xxx defines<br>
	 * C type : xadUINT32
	 */
	public int xc_Flags;
	/**
	 * ID of internal clients<br>
	 * C type : xadUINT32
	 */
	public int xc_Identifier;
	/** C type : const char* */
	public Pointer xc_ArchiverName;
	/** C type : xc_Free_callback* */
	public xadClient.xc_Free_callback xc_Free;
	/** <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h</i> */
	public interface xadBOOL_callback extends Callback {
		int apply(long size, Pointer data, xadMasterBase xadMasterBase);
	};
	/** <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h</i> */
	public interface xadERROR_callback extends Callback {
		int apply(xadArchiveInfo ai, xadMasterBase xadMasterBase);
	};
	/** <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h</i> */
	public interface xadERROR_callback2 extends Callback {
		int apply(xadArchiveInfo ai, xadMasterBase xadMasterBase);
	};
	/** <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h</i> */
	public interface xc_Free_callback extends Callback {
		void apply(xadArchiveInfo ai, xadMasterBase xadMasterBase);
	};
	public xadClient() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xc_Next", "xc_Version", "xc_MasterVersion", "xc_ClientVersion", "xc_ClientRevision", "xc_RecogSize", "xc_Flags", "xc_Identifier", "xc_ArchiverName", "xc_Free");
	}
	public xadClient(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadClient implements Structure.ByReference {
		
	};
	public static class ByValue extends xadClient implements Structure.ByValue {
		
	};
}