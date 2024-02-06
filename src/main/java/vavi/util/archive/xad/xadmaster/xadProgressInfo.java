package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * *<br>
 *    progress report stuff                                              *<br>
 *                                                                       *<br>
 * **********************************************************************<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:630</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadProgressInfo extends Structure {
	/**
	 * work modus<br>
	 * C type : xadUINT32
	 */
	public int xpi_Mode;
	/**
	 * the client doing the work<br>
	 * C type : xadClient*
	 */
	public vavi.util.archive.xad.xadmaster.xadClient.ByReference xpi_Client;
	/**
	 * current diskinfo, for disks<br>
	 * C type : xadDiskInfo*
	 */
	public vavi.util.archive.xad.xadmaster.xadDiskInfo.ByReference xpi_DiskInfo;
	/**
	 * current info for files<br>
	 * C type : xadFileInfo*
	 */
	public vavi.util.archive.xad.xadmaster.xadFileInfo.ByReference xpi_FileInfo;
	/**
	 * current filesize<br>
	 * C type : xadSize
	 */
	public long xpi_CurrentSize;
	/**
	 * for disks only<br>
	 * C type : xadUINT32
	 */
	public int xpi_LowCyl;
	/**
	 * for disks only<br>
	 * C type : xadUINT32
	 */
	public int xpi_HighCyl;
	/**
	 * see XADPIF flags<br>
	 * C type : xadUINT32
	 */
	public int xpi_Status;
	/**
	 * any of the error codes<br>
	 * C type : xadERROR
	 */
	public int xpi_Error;
	/**
	 * name of file to overwrite (V2)<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xpi_FileName;
	/**
	 * new name buffer, passed by hook (V2)<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xpi_NewName;
	public xadProgressInfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xpi_Mode", "xpi_Client", "xpi_DiskInfo", "xpi_FileInfo", "xpi_CurrentSize", "xpi_LowCyl", "xpi_HighCyl", "xpi_Status", "xpi_Error", "xpi_FileName", "xpi_NewName");
	}
	public xadProgressInfo(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadProgressInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends xadProgressInfo implements Structure.ByValue {
		
	};
}