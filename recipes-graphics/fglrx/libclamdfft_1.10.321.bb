SUMMARY = "AMD OpenCL Fft Library"
DESCRIPTION = "AMD OpenCL Fft Library"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://../clAmdFft-EULA.txt;md5=1b3158b1bef329c24a776cf76fb0c718"
INSANE_SKIP_${PN} = "ldflags"

PR = "r2"

SRC_URI = "http://developer.amd.com/wordpress/media/files/clAmdFft-${PV}.tar.gz"
SRC_URI[md5sum] = "f2b08c34a72719546ab290428e79e2b9"
SRC_URI[sha256sum] = "1a91cf96a2a766129ba396e389fafd09766d72cc27a97fea1749bc34c9b38019"

DEPENDS += "virtual/libgl"

S = "${WORKDIR}/clAmdFft"

do_unpack_amd(){
	tar xzvf ${WORKDIR}/clAmdFft-${PV}-Linux.tar.gz -C ${WORKDIR}/clAmdFft
}
addtask unpack_amd after do_unpack before do_patch

do_compile(){
}

do_install(){
	install -d -m 0755		${D}${bindir}
	install -m 0755  ${S}/bin${@bb.utils.contains("TARGET_ARCH", "x86_64", "64", "32", d)}/clAmdFft.Client-${PV} ${D}${bindir}/clAmdFft.Client
	install -d -m 0755		${D}${includedir}
	install -m 0644 		${S}/include/* ${D}${includedir}/
	install -d -m 0755		${D}${libdir}
	install -m 0755  ${S}/lib${@bb.utils.contains("TARGET_ARCH", "x86_64", "64", "32", d)}/libclAmdFft.Runtime.so.${PV} ${D}${libdir}/
	ln -sf libclAmdFft.Runtime.so.${PV} ${D}${libdir}/libclAmdFft.Runtime.so.1
	ln -sf libclAmdFft.Runtime.so.1 ${D}${libdir}/libclAmdFft.Runtime.so
}
