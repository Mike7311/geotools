/**
 */
package net.opengis.ows20.impl;

import net.opengis.ows20.AbstractReferenceBaseType;
import net.opengis.ows20.Ows20Package;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.w3.xlink.ActuateType;
import org.w3.xlink.ShowType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Reference Base Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getActuate <em>Actuate</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getArcrole <em>Arcrole</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getHref <em>Href</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getRole <em>Role</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getShow <em>Show</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link net.opengis.ows20.impl.AbstractReferenceBaseTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AbstractReferenceBaseTypeImpl extends EObjectImpl implements AbstractReferenceBaseType {
    /**
   * The default value of the '{@link #getActuate() <em>Actuate</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getActuate()
   * @generated
   * @ordered
   */
    protected static final ActuateType ACTUATE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getActuate() <em>Actuate</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getActuate()
   * @generated
   * @ordered
   */
    protected ActuateType actuate = ACTUATE_EDEFAULT;

    /**
   * This is true if the Actuate attribute has been set.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    protected boolean actuateESet;

    /**
   * The default value of the '{@link #getArcrole() <em>Arcrole</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getArcrole()
   * @generated
   * @ordered
   */
    protected static final String ARCROLE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getArcrole() <em>Arcrole</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getArcrole()
   * @generated
   * @ordered
   */
    protected String arcrole = ARCROLE_EDEFAULT;

    /**
   * The default value of the '{@link #getHref() <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getHref()
   * @generated
   * @ordered
   */
    protected static final String HREF_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getHref() <em>Href</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getHref()
   * @generated
   * @ordered
   */
    protected String href = HREF_EDEFAULT;

    /**
   * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
    protected static final String ROLE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getRole()
   * @generated
   * @ordered
   */
    protected String role = ROLE_EDEFAULT;

    /**
   * The default value of the '{@link #getShow() <em>Show</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getShow()
   * @generated
   * @ordered
   */
    protected static final ShowType SHOW_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getShow() <em>Show</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getShow()
   * @generated
   * @ordered
   */
    protected ShowType show = SHOW_EDEFAULT;

    /**
   * This is true if the Show attribute has been set.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    protected boolean showESet;

    /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
    protected static final String TITLE_EDEFAULT = null;

    /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
    protected String title = TITLE_EDEFAULT;

    /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
    protected static final String TYPE_EDEFAULT = "simple";

    /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
    protected String type = TYPE_EDEFAULT;

    /**
   * This is true if the Type attribute has been set.
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
    protected boolean typeESet;

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    protected AbstractReferenceBaseTypeImpl() {
    super();
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    protected EClass eStaticClass() {
    return Ows20Package.Literals.ABSTRACT_REFERENCE_BASE_TYPE;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ActuateType getActuate() {
    return actuate;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setActuate(ActuateType newActuate) {
    ActuateType oldActuate = actuate;
    actuate = newActuate;
    boolean oldActuateESet = actuateESet;
    actuateESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE, oldActuate, actuate, !oldActuateESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void unsetActuate() {
    ActuateType oldActuate = actuate;
    boolean oldActuateESet = actuateESet;
    actuate = ACTUATE_EDEFAULT;
    actuateESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE, oldActuate, ACTUATE_EDEFAULT, oldActuateESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isSetActuate() {
    return actuateESet;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getArcrole() {
    return arcrole;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setArcrole(String newArcrole) {
    String oldArcrole = arcrole;
    arcrole = newArcrole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ARCROLE, oldArcrole, arcrole));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getHref() {
    return href;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setHref(String newHref) {
    String oldHref = href;
    href = newHref;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__HREF, oldHref, href));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getRole() {
    return role;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setRole(String newRole) {
    String oldRole = role;
    role = newRole;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ROLE, oldRole, role));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public ShowType getShow() {
    return show;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setShow(ShowType newShow) {
    ShowType oldShow = show;
    show = newShow;
    boolean oldShowESet = showESet;
    showESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW, oldShow, show, !oldShowESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void unsetShow() {
    ShowType oldShow = show;
    boolean oldShowESet = showESet;
    show = SHOW_EDEFAULT;
    showESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW, oldShow, SHOW_EDEFAULT, oldShowESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isSetShow() {
    return showESet;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getTitle() {
    return title;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setTitle(String newTitle) {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TITLE, oldTitle, title));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String getType() {
    return type;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void setType(String newType) {
    String oldType = type;
    type = newType;
    boolean oldTypeESet = typeESet;
    typeESet = true;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE, oldType, type, !oldTypeESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void unsetType() {
    String oldType = type;
    boolean oldTypeESet = typeESet;
    type = TYPE_EDEFAULT;
    typeESet = false;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.UNSET, Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE, oldType, TYPE_EDEFAULT, oldTypeESet));
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean isSetType() {
    return typeESet;
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE:
        return getActuate();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ARCROLE:
        return getArcrole();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__HREF:
        return getHref();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ROLE:
        return getRole();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW:
        return getShow();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TITLE:
        return getTitle();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE:
        return getType();
    }
    return super.eGet(featureID, resolve, coreType);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE:
        setActuate((ActuateType)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ARCROLE:
        setArcrole((String)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__HREF:
        setHref((String)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ROLE:
        setRole((String)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW:
        setShow((ShowType)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TITLE:
        setTitle((String)newValue);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE:
        setType((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public void eUnset(int featureID) {
    switch (featureID) {
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE:
        unsetActuate();
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ARCROLE:
        setArcrole(ARCROLE_EDEFAULT);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__HREF:
        setHref(HREF_EDEFAULT);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ROLE:
        setRole(ROLE_EDEFAULT);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW:
        unsetShow();
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE:
        unsetType();
        return;
    }
    super.eUnset(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public boolean eIsSet(int featureID) {
    switch (featureID) {
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ACTUATE:
        return isSetActuate();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ARCROLE:
        return ARCROLE_EDEFAULT == null ? arcrole != null : !ARCROLE_EDEFAULT.equals(arcrole);
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__HREF:
        return HREF_EDEFAULT == null ? href != null : !HREF_EDEFAULT.equals(href);
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__ROLE:
        return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__SHOW:
        return isSetShow();
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case Ows20Package.ABSTRACT_REFERENCE_BASE_TYPE__TYPE:
        return isSetType();
    }
    return super.eIsSet(featureID);
  }

    /**
   * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
   * @generated
   */
    @Override
    public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (actuate: ");
    if (actuateESet) result.append(actuate); else result.append("<unset>");
    result.append(", arcrole: ");
    result.append(arcrole);
    result.append(", href: ");
    result.append(href);
    result.append(", role: ");
    result.append(role);
    result.append(", show: ");
    if (showESet) result.append(show); else result.append("<unset>");
    result.append(", title: ");
    result.append(title);
    result.append(", type: ");
    if (typeESet) result.append(type); else result.append("<unset>");
    result.append(')');
    return result.toString();
  }

} //AbstractReferenceBaseTypeImpl
