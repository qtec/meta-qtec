SUMMARY = "Pure Python Expect"
DESCRIPTION = "Pexpect is a pure Python expect-like module. Pexpect makes Python a better tool for controlling other applications."
SECTION = "devel/python"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1c7a725251880af8c6a148181665385b"

SRC_URI = "https://pypi.python.org/packages/e8/13/d0b0599099d6cd23663043a2a0bb7c61e58c6ba359b2656e6fb000ef5b98/pexpect-4.2.1.tar.gz"

SRC_URI[md5sum] = "3694410001a99dff83f0b500a1ca1c95"
SRC_URI[sha256sum] = "3d132465a75b57aa818341c6521392a06cc660feb3988d7f1074f39bd23c9a92"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/pexpect/"
UPSTREAM_CHECK_REGEX = "/pexpect/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/pexpect-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-terminal python3-ptyprocess"
