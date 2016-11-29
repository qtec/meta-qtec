SUMMARY = "AMD OpenCL Library"
DESCRIPTION = "AMD OpenCL Library"
LICENSE = "Proprietary"

PROVIDES += "virtual/opencl-icd"

LIC_FILES_CHKSUM = "file://APPSDK-EULA-linux.txt;md5=7140558ecf59472cbd7a0b76ea615282"
INSANE_SKIP_${PN} = "ldflags already-stripped"

SRC_URI = "http://developer.amd.com/amd-license-agreement-appsdk/AMD-APP-SDKInstaller-v3.0.130.135-GA-linux64.tar.bz2"
SRC_URI[md5sum] = "be19706292e4f554085d5d71dd62d0b0"
SRC_URI[sha256sum] = "27a6145a73910d2320fd017159cf72f16601c375c2b304644c31566f45cc26a6"

S = "${WORKDIR}/appsdk"

do_unpack_amd(){
	mkdir ${WORKDIR}/appsdk || true
	sh ${WORKDIR}/AMD-APP-SDK-v3.0.130.135-GA-linux64.sh --tar xvfC ${WORKDIR}/appsdk
}
addtask unpack_amd after do_unpack before do_patch

do_compile(){
}

FILES_${PN}-dev = "${libdir}/libOpenCL.so"
FILES_${PN} += "${libdir}/"

do_install(){
	install -d -m 0755		${D}${libdir}
	install -m 0755 ${S}/lib/x86_64/libamdocl12cl64.so ${D}${libdir}
	install -m 0755 ${S}/lib/x86_64/libamdocl64.so ${D}${libdir}
	install -m 0755 ${S}/lib/x86_64/libOpenCL.so.1 ${D}${libdir}

	ln -sf libOpenCL.so.1 ${D}${libdir}/libOpenCL.so
}
