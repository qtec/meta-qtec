SUMMARY = "AMD OpenCL Blas Library"
DESCRIPTION = "AMD OpenCL Blas Library"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://../clAmdBlas-EULA.txt;md5=1b3158b1bef329c24a776cf76fb0c718"
INSANE_SKIP_${PN} = "ldflags"

PR = "r2"

DEPENDS += "virtual/libgl"

SRC_URI = "http://developer.amd.com/wordpress/media/files/clAmdBlas-${PV}.tar.gz"
SRC_URI[md5sum] = "41a203355cb63097748a6d93518977b4"
SRC_URI[sha256sum] = "5c7c84da0acf8196affeb8e5df47a54b172f8ac11b9443dc159030bbf8c741d9"

S = "${WORKDIR}/clAmdBlas"

do_unpack_amd(){
	tar xzvf ${WORKDIR}/clAmdBlas-${PV}-Linux.tar.gz -C ${WORKDIR}/clAmdBlas
}
addtask unpack_amd after do_unpack before do_patch

do_compile(){
}

do_install(){
	install -d -m 0755		${D}${bindir}
	install -m 0755  ${S}/bin${@bb.utils.contains("TARGET_ARCH", "x86_64", "64", "32", d)}/cl* ${D}${bindir}/
	install -d -m 0755		${D}${includedir}
	install -m 0644 		${S}/include/* ${D}${includedir}/
	install -d -m 0755		${D}${libdir}
	install -m 0755  ${S}/lib${@bb.utils.contains("TARGET_ARCH", "x86_64", "64", "32", d)}/libclAmdBlas.so.${PV} ${D}${libdir}/
	install -m 0755  ${S}/lib64/libclAmdBlas.so.${PV} ${D}${libdir}/
	ln -sf libclAmdBlas.so.${PV} ${D}${libdir}/libclAmdBlas.so.1
	ln -sf libclAmdBlas.so.1 ${D}${libdir}/libclAmdBlas.so
}
