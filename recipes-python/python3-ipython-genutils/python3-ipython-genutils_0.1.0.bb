SUMMARY = "Vestigial utilities from IPython"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=f7c3032c3ac398265224533a0a333a35"

SRC_URI = "https://pypi.python.org/packages/71/b7/a64c71578521606edbbce15151358598f3dfb72a3431763edc2baf19e71f/ipython_genutils-0.1.0.tar.gz"

SRC_URI[md5sum] = "9a8afbe0978adbcbfcb3b35b2d015a56"
SRC_URI[sha256sum] = "3a0624a251a26463c9dfa0ffa635ec51c4265380980d9a50d65611c3c2bd82a6"

S = "${WORKDIR}/ipython_genutils-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-crypt"
