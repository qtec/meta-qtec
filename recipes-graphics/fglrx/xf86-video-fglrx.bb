SUMMARY = "FGLRX xorg driver"
DESCRIPTION = "The FGLRX xorg driver contains the proprietary xorg module for ATI/AMD cards"
LICENSE = "Proprietary"

require amd-source.inc

# These are closed binaries generated elsewhere so don't check ldflags
INSANE_SKIP_${PN} = "ldflags dev-so libdir already-stripped"
INSANE_SKIP_libgl-fglrx = "ldflags"

#Dont show missing symbols warning
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Dont do the debian autoname
DEBIAN_NOAUTONAME_${PN} = "1"
DEBIAN_NOAUTONAME_${PN}-dev = "1"
DEBIAN_NOAUTONAME_${PN}-dbg = "1"

RDEPENDS_${PN} += "fglrx-module bash lsb fglrx-libgles amdappsdk"
DEPENDS += "mesa libxrandr libxinerama libxrender freetype fontconfig amdappsdk"
RCONFLICTS_${PN} += "xserver-xorg-extension-glx mesa-xlib"
CONFLICTS += "xserver-xorg-extension-glx mesa-xlib"
PROVIDES += "virtual/libgl"
PACKAGES =+ "libgl-fglrx"
DEBIAN_NOAUTONAME_libgl-fglrx = "1"
RREPLACES_libgl-fglrx += "libgl libgl1"
RPROVIDES_libgl-fglrx += "libgl libgl1"
RPROVIDES_${PN} = "clinfo"
RCONFLICTS_libgl-fglrx += "libgl libgl1"

export INSTALL_MOD_DIR="kernel/fglrx"
export KERNEL_SRC="${STAGING_KERNEL_DIR}"

FILES_libgl-fglrx = "${libdir}/libGL.so.*"
FILES_${PN} += "${libdir}/xorg/modules ${libdir}/modules ${libdir}/libAMDXvBA.cap ${libdir}/fglrx ${prefix}/share/fglrx/fglrx.ids ${libdir}/lib*so ${libdir}/dri/*so /lib64/* ${prefix}/share/"
FILES_${PN}-dbg += "${libdir}/xorg/modules/.debug ${libdir}/xorg/modules/fglrx/.debug ${libdir}/xorg/modules/linux/.debug"
FILES_${PN}-dev = "${includedir}"

do_compile(){
	cat common/lib/modules/fglrx/build_mod/fglrxko_pci_ids.h | \
		sed -n -r -e '/FGL_ASIC_ID/ s/.*\(0x(.{4})\).*/1002\1/p'\
		| tr a-z A-Z | sort -u > fglrx.ids
}

do_install(){
	AMDARCH=x86${@bb.utils.contains("TARGET_ARCH", "x86_64", "_64", "", d)}
	LIBARCH=lib${@bb.utils.contains("TARGET_ARCH", "x86_64", "64", "", d)}
	XPICARCH=xpic${@bb.utils.contains("TARGET_ARCH", "x86_64", "_64a", "", d)}

	#etc
	install -d -m 0755		${D}${sysconfdir}/
	cp	-r ${S}/common/etc/* ${D}${sysconfdir}/
	cp	-r ${S}/arch/${AMDARCH}/etc/* ${D}${sysconfdir}/
	rm	${D}${sysconfdir}/ati/atiapfxx*
	#Control file from new drivers show nasty logo (Unsupported hardware)
	install -m 0644 		${WORKDIR}/control ${D}${sysconfdir}/ati/

	#share
	install -d -m 0755		${D}${prefix}/share/
	cp	-r ${S}/common/usr/share/* ${D}${prefix}/share/
	cp	-r ${S}/arch/${AMDARCH}/usr/share/* ${D}${prefix}/share/
	install -d -m 0755		${D}${prefix}/share/fglrx
	install -m 0644			fglrx.ids ${D}${prefix}/share/fglrx/

	#include
	install -d -m 0755		${D}${includedir}
	cp	-r ${S}/common/usr/include/* ${D}${includedir}

	#sbin
	install -d -m 0755		${D}${sbindir}
	cp	${S}/common/usr/sbin/* ${D}${sbindir}
	cp	${S}/arch/${AMDARCH}/usr/sbin/* ${D}${sbindir}

	#bin
	install -d -m 0755		${D}${bindir}
	cp	${S}/common/usr/X11R6/bin/* ${D}${bindir}
	cp	${S}/arch/${AMDARCH}/usr/bin/* ${D}${bindir}
	cp	${S}/arch/${AMDARCH}/usr/X11R6/bin/* ${D}${bindir}
	chmod   a+x  ${D}${bindir}/*

	#lib
	install -d -m 0755		${D}${libdir}
	cp	${S}/arch/${AMDARCH}/usr/${LIBARCH}/*\.so* ${D}${libdir}
	cp	-r ${S}/arch/${AMDARCH}/usr/X11R6/${LIBARCH}/* ${D}${libdir}
	rm      -r ${D}${libdir}/fglrx/
	cp	${S}/arch/${AMDARCH}/usr/X11R6/${LIBARCH}/fglrx/fglrx-libGL.so.1.2 ${D}${libdir}/libGL.so.1.2
	cp	-r ${S}/arch/${AMDARCH}/usr/X11R6/${LIBARCH}/modules/dri ${D}${libdir}/

	#x11
	install -d -m 0755		${D}${libdir}/xorg/modules/
	cp 	${S}/${XPICARCH}/usr/X11R6/${LIBARCH}/modules/*so ${D}${libdir}/xorg/modules/
	install -d -m 0755		${D}${libdir}/xorg/modules/linux
	cp 	${S}/${XPICARCH}/usr/X11R6/${LIBARCH}/modules/linux/* ${D}${libdir}/xorg/modules/linux/
	install -d -m 0755		${D}${libdir}/xorg/modules/fglrx
	cp 	${S}/${XPICARCH}/usr/X11R6/${LIBARCH}/modules/extensions/fglrx/fglrx-libglx.so ${D}${libdir}/xorg/modules/fglrx/libglx.so
	cp 	${S}/${XPICARCH}/usr/X11R6/${LIBARCH}/modules/drivers/* ${D}${libdir}/xorg/modules/fglrx/

	#links
	ln -sf libXvBAW.so.1.0 ${D}${libdir}/libXvBAW.so
	ln -sf libXvBAW.so.1.0 ${D}${libdir}/libXvBAW.so.1
	ln -sf libfglrx_dm.so.1.0 ${D}${libdir}/libfglrx_dm.so
	ln -sf libfglrx_dm.so.1.0 ${D}${libdir}/libfglrx_dm.so.1
	ln -sf libAMDXvBA.so.1.0 ${D}${libdir}/libAMDXvBA.so
	ln -sf libAMDXvBA.so.1.0 ${D}${libdir}/libAMDXvBA.so.1
	ln -sf libatiuki.so.1.0 ${D}${libdir}/libatiuki.so
	ln -sf libatiuki.so.1.0 ${D}${libdir}/libatiuki.so.1
	ln -sf libOpenCL.so.1 ${D}${libdir}/libOpenCL.so
	ln -sf libGL.so.1.2 	${D}${libdir}/libGL.so.1
	ln -sf libGL.so.1.2 	${D}${libdir}/libGL.so

	#Use amdapp instead
	rm ${D}${libdir}/libOpenCL.so
	rm ${D}${libdir}/libamdocl12cl64.so
	rm ${D}${libdir}/libamdocl64.so
	rm ${D}${libdir}/libOpenCL.so.1

}
