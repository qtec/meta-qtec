SUMMARY = "Python plotting package"
DESCRIPTION = "matplotlib strives to produce publication quality 2D graphics for interactive graphing, scientific publishing, user interface development and web application servers targeting multiple user interfaces and hardcopy output formats. There is a ‘pylab’ mode which emulates matlab graphics."
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=e025dc4394669277f0539e8833c27275"

DEPENDS += "freetype libpng"

SRC_URI = "https://pypi.python.org/packages/75/4e/2374eed18ac34421ccd7b4907080abd3009e112ca2c11b100c18961312e0/matplotlib-1.5.3.tar.gz"
SRC_URI += "file://fixbasedirs.patch"

SRC_URI[md5sum] = "ba993b06113040fee6628d74b80af0fd"
SRC_URI[sha256sum] = "a0a5dc39f785014f2088fed2c6d2d129f0444f71afbb9c44f7bdf1b14d86ebbc"

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/matplotlib/"
UPSTREAM_CHECK_REGEX = "/matplotlib/(?P<pver>(\d+[\.\-_]*)+)"

S = "${WORKDIR}/matplotlib-${PV}"

inherit setuptools3

RDEPENDS_${PN} += "python3-numpy freetype libpng python3-pyparsing python3-cycler python3-dateutil"
