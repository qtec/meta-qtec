SUMMARY = "Library for building powerful interactive command lines in Python"
DESCRIPTION = "prompt_toolkit is a library for building powerful interactive command lines and terminal applications in Python"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2cde7da89f0c1f3e49bf968d00d554f"

SRC_URI = "https://pypi.python.org/packages/83/14/5ac258da6c530eca02852ee25c7a9ff3ca78287bb4c198d0d0055845d856/prompt_toolkit-1.0.9.tar.gz"

SRC_URI[md5sum] = "a39f91a54308fb7446b1a421c11f227c"
SRC_URI[sha256sum] = "cd6523b36adc174cc10d54b1193eb626b4268609ff6ea92c15bcf1996609599c"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/prompt_toolkit/"
UPSTREAM_CHECK_REGEX = "/prompt_toolkit/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/prompt_toolkit-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-wcwidth"
