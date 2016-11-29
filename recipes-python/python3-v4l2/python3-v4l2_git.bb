DESCRIPTION = "A Python binding for the v4l2 (video4linux2) userspace api, using ctypes"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=751419260aa954499f7abaabaa882bbe"


SRC_URI = "git://github.com/qtec/python-v4l2"
SRCREV = "a185ceac598547fa5626ebfb71bfd5e5c53d60db"

PV = "1.3+git${SRCPV}"

include python-v4l2.inc

S = "${WORKDIR}/git/v4l2"

inherit setuptools3
RDEPENDS_${PN} += "python3-ctypes"
