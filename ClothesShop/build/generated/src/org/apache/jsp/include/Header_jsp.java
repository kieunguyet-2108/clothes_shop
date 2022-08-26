package org.apache.jsp.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!-- Page Preloder -->\n");
      out.write("<div id=\"preloder\">\n");
      out.write("    <div class=\"loader\"></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!-- Humberger Begin -->\n");
      out.write("<div class=\"humberger__menu__overlay\"></div>\n");
      out.write("<div class=\"humberger__menu__wrapper\">\n");
      out.write("    <div class=\"humberger__menu__logo\">\n");
      out.write("        <a href=\"#\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"humberger__menu__cart\">\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("            <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a></li>\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"humberger__menu__widget\">\n");
      out.write("        <div class=\"header__top__right__language\">\n");
      out.write("            <img src=\"img/language.png\" alt=\"\">\n");
      out.write("            <div>English</div>\n");
      out.write("            <span class=\"arrow_carrot-down\"></span>\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                <li><a href=\"#\">English</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"header__top__right__auth\">\n");
      out.write("            <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <nav class=\"humberger__menu__nav mobile-menu\">\n");
      out.write("        <ul>\n");
      out.write("            <li class=\"active\"><a href=\"./index.html\">Home</a></li>\n");
      out.write("            <li><a href=\"./shop-grid.html\">Shop</a></li>\n");
      out.write("            <li><a href=\"#\">Pages</a>\n");
      out.write("                <ul class=\"header__menu__dropdown\">\n");
      out.write("                    <li><a href=\"./shop-details.html\">Shop Details</a></li>\n");
      out.write("                    <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\n");
      out.write("                    <li><a href=\"./checkout.html\">Check Out</a></li>\n");
      out.write("                    <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </li>\n");
      out.write("            <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("            <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("    <div id=\"mobile-menu-wrap\"></div>\n");
      out.write("    <div class=\"header__top__right__social\">\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("        <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"humberger__menu__contact\">\n");
      out.write("        <ul>\n");
      out.write("            <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\n");
      out.write("            <li>Free Shipping for all Order of $99</li>\n");
      out.write("        </ul>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!-- Humberger End -->\n");
      out.write("\n");
      out.write("<!-- Header Section Begin -->\n");
      out.write("<header class=\"header\">\n");
      out.write("    <div class=\"header__top\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"header__top__left\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li><i class=\"fa fa-envelope\"></i> hello@colorlib.com</li>\n");
      out.write("                            <li>Free Shipping for all Order of $99</li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-6\">\n");
      out.write("                    <div class=\"header__top__right\">\n");
      out.write("                        <div class=\"header__top__right__social\">\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-facebook\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-twitter\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-linkedin\"></i></a>\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-pinterest-p\"></i></a>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"header__top__right__language\">\n");
      out.write("                            <img src=\"img/language.png\" alt=\"\">\n");
      out.write("                            <div>English</div>\n");
      out.write("                            <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                            <ul>\n");
      out.write("                                <li><a href=\"#\">Spanis</a></li>\n");
      out.write("                                <li><a href=\"#\">English</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"header__top__right__auth\">\n");
      out.write("                            <a href=\"#\"><i class=\"fa fa-user\"></i> Login</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-3\">\n");
      out.write("                <div class=\"header__logo\">\n");
      out.write("                    <a href=\"./index.html\"><img src=\"img/logo.png\" alt=\"\"></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-6\">\n");
      out.write("                <nav class=\"header__menu\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"./index.html\">Home</a></li>\n");
      out.write("                        <li class=\"active\"><a href=\"./shop-grid.html\">Shop</a></li>\n");
      out.write("                        <li><a href=\"#\">Pages</a>\n");
      out.write("                            <ul class=\"header__menu__dropdown\">\n");
      out.write("                                <li><a href=\"./shop-details.html\">Shop Details</a></li>\n");
      out.write("                                <li><a href=\"./shoping-cart.html\">Shoping Cart</a></li>\n");
      out.write("                                <li><a href=\"./checkout.html\">Check Out</a></li>\n");
      out.write("                                <li><a href=\"./blog-details.html\">Blog Details</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        <li><a href=\"./blog.html\">Blog</a></li>\n");
      out.write("                        <li><a href=\"./contact.html\">Contact</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-3\">\n");
      out.write("                <div class=\"header__cart\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-heart\"></i> <span>1</span></a></li>\n");
      out.write("                        <li><a href=\"#\"><i class=\"fa fa-shopping-bag\"></i> <span>3</span></a>\n");
      out.write("                         <ul class=\"header__cart__dropdown\">\n");
      out.write("                                <li class=\"header__cart__item\">\n");
      out.write("                                    <div class=\"header__cart__item__pic\">\n");
      out.write("                                        <img src=\"img/cart/cart-1.jpg\" alt=\"\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"header__cart__item__text\">\n");
      out.write("                                        <span>Peony</span>\n");
      out.write("                                        <span>Qty: 02</span>\n");
      out.write("                                        <span>$45.00</span>\n");
      out.write("                                    </div>\n");
      out.write("                                </li>\n");
      out.write(" \n");
      out.write("                        </ul>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                    <div class=\"header__cart__price\">item: <span>$150.00</span></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"humberger__open\">\n");
      out.write("            <i class=\"fa fa-bars\"></i>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</header>\n");
      out.write("<!-- Header Section End -->\n");
      out.write("\n");
      out.write("<!-- Hero Section Begin -->\n");
      out.write("<section class=\"hero hero-normal\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-lg-3\">\n");
      out.write("                <div class=\"hero__categories\">\n");
      out.write("                    <div class=\"hero__categories__all\">\n");
      out.write("                        <i class=\"fa fa-bars\"></i>\n");
      out.write("                        <span>All departments</span>\n");
      out.write("                    </div>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"#\">Fresh Meat</a></li>\n");
      out.write("                        <li><a href=\"#\">Vegetables</a></li>\n");
      out.write("                        <li><a href=\"#\">Fruit & Nut Gifts</a></li>\n");
      out.write("                        <li><a href=\"#\">Fresh Berries</a></li>\n");
      out.write("                        <li><a href=\"#\">Ocean Foods</a></li>\n");
      out.write("                        <li><a href=\"#\">Butter & Eggs</a></li>\n");
      out.write("                        <li><a href=\"#\">Fastfood</a></li>\n");
      out.write("                        <li><a href=\"#\">Fresh Onion</a></li>\n");
      out.write("                        <li><a href=\"#\">Papayaya & Crisps</a></li>\n");
      out.write("                        <li><a href=\"#\">Oatmeal</a></li>\n");
      out.write("                        <li><a href=\"#\">Fresh Bananas</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-lg-9\">\n");
      out.write("                <div class=\"hero__search\">\n");
      out.write("                    <div class=\"hero__search__form\">\n");
      out.write("                        <form action=\"#\">\n");
      out.write("                            <div class=\"hero__search__categories\">\n");
      out.write("                                All Categories\n");
      out.write("                                <span class=\"arrow_carrot-down\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"text\" placeholder=\"What do yo u need?\">\n");
      out.write("                            <button type=\"submit\" class=\"site-btn\">SEARCH</button>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"hero__search__phone\">\n");
      out.write("                        <div class=\"hero__search__phone__icon\">\n");
      out.write("                            <i class=\"fa fa-phone\"></i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"hero__search__phone__text\">\n");
      out.write("                            <h5>+65 11.188.888</h5>\n");
      out.write("                            <span>support 24/7 time</span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("<!-- Hero Section End -->");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
