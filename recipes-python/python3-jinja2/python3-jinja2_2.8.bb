SUMMARY = "A small but fast and easy to use stand-alone template engine written in pure python."
DESCRIPTION = "Jinja2 is a template engine written in pure Python. It provides a Django inspired non-XML syntax but supports inline expressions and an optional sandboxed environment."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=20c831f91dd3bd486020f672ba2be386"

SRC_URI = "https://pypi.python.org/packages/f2/2f/0b98b06a345a761bec91a079ccae392d282690c2d8272e708f4d10829e22/Jinja2-2.8.tar.gz"

SRC_URI[md5sum] = "edb51693fe22c53cee5403775c71a99e"
SRC_URI[sha256sum] = "bc1ff2ff88dbfacefde4ddde471d1417d3b304e8df103a7a9437d47269201bf4"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/jinja2/"
UPSTREAM_CHECK_REGEX = "/jinja2/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/Jinja2-${PV}"

inherit setuptools3

do_configure_prepend(){
	rm -f Makefile
}

RDEPENDS_${PN} += "python3-markupsafe"
