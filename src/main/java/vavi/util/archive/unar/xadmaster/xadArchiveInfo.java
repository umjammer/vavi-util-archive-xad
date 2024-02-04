package vavi.util.archive.unar.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.LongByReference;
import java.util.Arrays;
import java.util.List;
/**
 * *<br>
 *    information structures                                             *<br>
 *                                                                       *<br>
 * **********************************************************************<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:314</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadArchiveInfo extends Structure {
	/**
	 * pointer to unarchiving client<br>
	 * C type : xadClient*
	 */
	public vavi.util.archive.unar.xadmaster.xadClient.ByReference xai_Client;
	/**
	 * private client data<br>
	 * C type : xadPTR
	 */
	public Pointer xai_PrivateClient;
	/**
	 * password for crypted archives<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xai_Password;
	/**
	 * read only XADAIF_ flags<br>
	 * C type : xadUINT32
	 */
	public int xai_Flags;
	/**
	 * lowest cylinder to unarchive<br>
	 * C type : xadUINT32
	 */
	public int xai_LowCyl;
	/**
	 * highest cylinder to unarchive<br>
	 * C type : xadUINT32
	 */
	public int xai_HighCyl;
	/**
	 * input position, read only<br>
	 * C type : xadSize
	 */
	public long xai_InPos;
	/**
	 * input size, read only<br>
	 * C type : xadSize
	 */
	public long xai_InSize;
	/**
	 * output position, read only<br>
	 * C type : xadSize
	 */
	public long xai_OutPos;
	/**
	 * output file size, read only<br>
	 * C type : xadSize
	 */
	public long xai_OutSize;
	/**
	 * data pointer for file arcs<br>
	 * C type : xadFileInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadFileInfo.ByReference xai_FileInfo;
	/**
	 * data pointer for disk arcs<br>
	 * C type : xadDiskInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadDiskInfo.ByReference xai_DiskInfo;
	/**
	 * data pointer for current file arc<br>
	 * C type : xadFileInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadFileInfo.ByReference xai_CurFile;
	/**
	 * data pointer for current disk arc<br>
	 * C type : xadDiskInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadDiskInfo.ByReference xai_CurDisk;
	/**
	 * last error, when XADAIF_FILECORRUPT (V2)<br>
	 * C type : xadERROR
	 */
	public int xai_LastError;
	/**
	 * array of start offsets from parts (V2)<br>
	 * C type : xadSize*
	 */
	public LongByReference xai_MultiVolume;
	/**
	 * linked list of skip entries (V3)<br>
	 * C type : xadSkipInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadSkipInfo.ByReference xai_SkipInfo;
	/**
	 * for filesystem clients (V5)<br>
	 * C type : xadImageInfo*
	 */
	public vavi.util.archive.unar.xadmaster.xadImageInfo.ByReference xai_ImageInfo;
	/**
	 * Input archive name if available (V7)<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xai_InName;
	public xadArchiveInfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xai_Client", "xai_PrivateClient", "xai_Password", "xai_Flags", "xai_LowCyl", "xai_HighCyl", "xai_InPos", "xai_InSize", "xai_OutPos", "xai_OutSize", "xai_FileInfo", "xai_DiskInfo", "xai_CurFile", "xai_CurDisk", "xai_LastError", "xai_MultiVolume", "xai_SkipInfo", "xai_ImageInfo", "xai_InName");
	}
	public xadArchiveInfo(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadArchiveInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends xadArchiveInfo implements Structure.ByValue {
		
	};
}
