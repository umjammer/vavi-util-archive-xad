package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * This structure is nearly complete private to either xadmaster or its<br>
 * clients. An application program may access for reading only xai_Client,<br>
 * xai_Flags, xai_FileInfo and xai_DiskInfo. For xai_Flags only XADAIF_CRYPTED<br>
 * and XADAIF_FILECORRUPT are useful. All the other stuff is private and should<br>
 * not be accessed!<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:373</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadFileInfo extends Structure {
	/** C type : xadFileInfo* */
	public xadFileInfo.ByReference xfi_Next;
	/**
	 * number of entry<br>
	 * C type : xadUINT32
	 */
	public int xfi_EntryNumber;
	/**
	 * additional archiver text<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_EntryInfo;
	/**
	 * client private, see XAD_OBJPRIVINFOSIZE<br>
	 * C type : xadPTR
	 */
	public Pointer xfi_PrivateInfo;
	/**
	 * see XADFIF_xxx defines<br>
	 * C type : xadUINT32
	 */
	public int xfi_Flags;
	/**
	 * see XAD_OBJNAMESIZE tag<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_FileName;
	/**
	 * see XAD_OBJCOMMENTSIZE tag<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_Comment;
	/**
	 * AmigaOS3 bits (including multiuser)<br>
	 * C type : xadUINT32
	 */
	public int xfi_Protection;
	/**
	 * user ID<br>
	 * C type : xadUINT32
	 */
	public int xfi_OwnerUID;
	/**
	 * group ID<br>
	 * C type : xadUINT32
	 */
	public int xfi_OwnerGID;
	/**
	 * user name<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_UserName;
	/**
	 * group name<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_GroupName;
	/**
	 * size of this file<br>
	 * C type : xadSize
	 */
	public long xfi_Size;
	/**
	 * crunched size of group<br>
	 * C type : xadSize
	 */
	public long xfi_GroupCrSize;
	/**
	 * crunched size<br>
	 * C type : xadSize
	 */
	public long xfi_CrunchSize;
	/**
	 * name and path of link<br>
	 * C type : xadSTRPTR
	 */
	public Pointer xfi_LinkName;
	/** C type : xadDate */
	public xadDate xfi_Date;
	/**
	 * File Generation [0...0xFFFF] (V3)<br>
	 * C type : xadUINT16
	 */
	public short xfi_Generation;
	/**
	 * crunched data position (V3)<br>
	 * C type : xadSize
	 */
	public long xfi_DataPos;
	/**
	 * pointer to 2nd fork for Mac (V7)<br>
	 * C type : xadFileInfo*
	 */
	public xadFileInfo.ByReference xfi_MacFork;
	/**
	 * protection bits for Unix (V11)<br>
	 * C type : xadUINT16
	 */
	public short xfi_UnixProtect;
	/**
	 * protection bits for MS-DOS (V11)<br>
	 * C type : xadUINT8
	 */
	public byte xfi_DosProtect;
	/**
	 * XADFILETYPE to define type of exe files (V11)<br>
	 * C type : xadUINT8
	 */
	public byte xfi_FileType;
	/**
	 * pointer to special data (V11)<br>
	 * C type : xadSpecial*
	 */
	public vavi.util.archive.xad.xadmaster.xadSpecial.ByReference xfi_Special;
	public xadFileInfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xfi_Next", "xfi_EntryNumber", "xfi_EntryInfo", "xfi_PrivateInfo", "xfi_Flags", "xfi_FileName", "xfi_Comment", "xfi_Protection", "xfi_OwnerUID", "xfi_OwnerGID", "xfi_UserName", "xfi_GroupName", "xfi_Size", "xfi_GroupCrSize", "xfi_CrunchSize", "xfi_LinkName", "xfi_Date", "xfi_Generation", "xfi_DataPos", "xfi_MacFork", "xfi_UnixProtect", "xfi_DosProtect", "xfi_FileType", "xfi_Special");
	}
	public xadFileInfo(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadFileInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends xadFileInfo implements Structure.ByValue {
		
	};
}