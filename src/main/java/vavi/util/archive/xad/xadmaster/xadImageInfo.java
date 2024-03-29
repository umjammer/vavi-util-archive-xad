package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * for XADHC_IMAGEINFO<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:286</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadImageInfo extends Structure {
	/**
	 * usually 512<br>
	 * C type : xadUINT32
	 */
	public int xii_SectorSize;
	/**
	 * of the image file<br>
	 * C type : xadUINT32
	 */
	public int xii_FirstSector;
	/**
	 * of the image file<br>
	 * C type : xadUINT32
	 */
	public int xii_NumSectors;
	/**
	 * of this device type<br>
	 * C type : xadUINT32
	 */
	public int xii_TotalSectors;
	public xadImageInfo() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xii_SectorSize", "xii_FirstSector", "xii_NumSectors", "xii_TotalSectors");
	}
	/**
	 * @param xii_SectorSize usually 512<br>
	 * C type : xadUINT32<br>
	 * @param xii_FirstSector of the image file<br>
	 * C type : xadUINT32<br>
	 * @param xii_NumSectors of the image file<br>
	 * C type : xadUINT32<br>
	 * @param xii_TotalSectors of this device type<br>
	 * C type : xadUINT32
	 */
	public xadImageInfo(int xii_SectorSize, int xii_FirstSector, int xii_NumSectors, int xii_TotalSectors) {
		super();
		this.xii_SectorSize = xii_SectorSize;
		this.xii_FirstSector = xii_FirstSector;
		this.xii_NumSectors = xii_NumSectors;
		this.xii_TotalSectors = xii_TotalSectors;
	}
	public xadImageInfo(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadImageInfo implements Structure.ByReference {
		
	};
	public static class ByValue extends xadImageInfo implements Structure.ByValue {
		
	};
}
