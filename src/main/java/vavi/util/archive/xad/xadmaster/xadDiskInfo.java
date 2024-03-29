package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:537</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadDiskInfo extends Structure {
	/** C type : xadDiskInfo* */
	public xadDiskInfo.ByReference xdi_Next;
	/**
	 * number of entry<br>
	 * C type : xadUINT32
	 */
	public int xdi_EntryNumber;
	/**
	 * additional archiver text<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xdi_EntryInfo;
	/**
	 * client private, see XAD_OBJPRIVINFOSIZE<br>
	 * C type : xadPTR
	 */
	public Pointer xdi_PrivateInfo;
	/**
	 * see XADDIF_xxx defines<br>
	 * C type : xadUINT32
	 */
	public int xdi_Flags;
	/** C type : xadUINT32 */
	public int xdi_SectorSize;
	/**
	 * see devices/trackdisk.h<br>
	 * C type : xadUINT32
	 */
	public int xdi_TotalSectors;
	/**
	 * to find out what these<br>
	 * C type : xadUINT32
	 */
	public int xdi_Cylinders;
	/**
	 * fields mean, they are equal<br>
	 * C type : xadUINT32
	 */
	public int xdi_CylSectors;
	/**
	 * to struct DriveGeometry<br>
	 * C type : xadUINT32
	 */
	public int xdi_Heads;
	/** C type : xadUINT32 */
	public int xdi_TrackSectors;
	/**
	 * lowest cylinder stored<br>
	 * C type : xadUINT32
	 */
	public int xdi_LowCyl;
	/**
	 * highest cylinder stored<br>
	 * C type : xadUINT32
	 */
	public int xdi_HighCyl;
	/**
	 * number of BlockInfo entries<br>
	 * C type : xadUINT32
	 */
	public int xdi_BlockInfoSize;
	/**
	 * see XADBIF_xxx defines and XAD_OBJBLOCKENTRIES tag<br>
	 * C type : xadUINT8*
	 */
	public Pointer xdi_BlockInfo;
	/**
	 * linked list with info texts<br>
	 * C type : xadTextInfo*
	 */
	public vavi.util.archive.xad.xadmaster.xadTextInfo.ByReference xdi_TextInfo;
	/**
	 * crunched data position (V3)<br>
	 * C type : xadSize
	 */
	public long xdi_DataPos;
	public xadDiskInfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xdi_Next", "xdi_EntryNumber", "xdi_EntryInfo", "xdi_PrivateInfo", "xdi_Flags", "xdi_SectorSize", "xdi_TotalSectors", "xdi_Cylinders", "xdi_CylSectors", "xdi_Heads", "xdi_TrackSectors", "xdi_LowCyl", "xdi_HighCyl", "xdi_BlockInfoSize", "xdi_BlockInfo", "xdi_TextInfo", "xdi_DataPos");
	}
	public xadDiskInfo(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadDiskInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends xadDiskInfo implements Structure.ByValue {
		
	};
}
