DESCRIPTION = "Xform tools"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a23a74b3f4caf9616230789d94217acb"

SRC_URI = "git://github.com/qtec/xform-tools.git"
SRCREV = "6f9926567876ea70820f2a9bf496ea9b0bea3fd5"

S = "${WORKDIR}/git"

do_install(){
	install -d ${D}${bindir}
	install -m 755 xform-gain-generator  ${D}${bindir}/
}
