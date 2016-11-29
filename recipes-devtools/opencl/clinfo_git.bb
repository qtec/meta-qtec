DESCRIPTION = "Print all known information about all available OpenCL platforms and devices in the system"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=069146d1c0028c0ef02b59ad670eec54"

DEPENDS = "opencl-headers virtual/opencl-icd"

SRC_URI = "git://github.com/Oblomov/clinfo.git;protocol=https"

SRCREV = "271b88488df434eb68eb2d05996c39b5d78fe50b"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 755 clinfo ${D}${bindir}/
}

