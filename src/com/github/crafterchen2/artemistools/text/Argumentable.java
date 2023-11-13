package com.github.crafterchen2.artemistools.text;

/**
 * The {@code Argumentable} interface is used to replace each occurrence
 * of a specific placeholder in a string.
 * <p>
 * As this is an interface, it works very well with enums, but can also be implemented by normal classes.
 * For disclosure purposes: This interface uses the {@code replaceAll(String regex, String replacement)}
 * method from the Java class String.
 * <h3>
 * Usage example
 * </h3>
 * Explained using the static {@code withArgs(String rv, String placeHolder, Object... args)} variant.
 * <blockquote>
 *     <pre>
 *          String rv = "Hello ARG0 friends!";
 *          String placeHolder = "ARG";
 *          String result = Argumentable.withArgs(rv, placeholder, 3);
 *          // result would now be "Hello 3 friends!"
 *          result = Argumentable.withArgs(rv, placeholder, 3, 4);
 *          // result would still be "Hello 3 friends!"
 *          result = Argumentable.withArgs(rv, placeholder);
 *          // result would now be "Hello ARG0 friends!"
 *          rv = "ARG0 only cares about ARG1 things.";
 *          result = Argumentable.withArgs(rv, placeholder, "John", 5);
 *          // result would now be "John onjy cares about 5 things."
 *     </pre>
 *</blockquote>
 *
 * @version     13 Nov 2023
 * @author      Benjamin Decker (aka. Crafterchen2)
 * @see         GenericTexts
 */
public interface Argumentable {

    /**
     * Replaces every occurrence of {@code getPlaceHolder()+n} in the string representation of the object
     * of the implementing class, where {@code n} represents the index of args.
     * <p>
     * If {@code args} doesn't have enough elements, then the {@code getPlaceHolder()+m} will remain
     * as {@code getPlaceHolder()+m}, where {@code m} is an {@code int >= args.length}.
     * <p>
     * If {@code args} has too many elements, then the method completes normally.
     * @param args The objects that replace {@code getPlaceHolder()+n}, where {@code n} is the index
     * of {@code args}.
     * @return The modified string.
     * @see #withArgs(String, Object...)
     * @see #withArgs(String, String, Object...)
     */
    default String withArgs(Object... args){
        return withArgs(toString(),args);
    }

    /**
     * Replaces every occurrence of {@code getPlaceHolder()+n} in the string {@code rv},
     * where {@code n} represents the index of args.
     * <p>
     * If {@code args} doesn't have enough elements, then the {@code getPlaceHolder()+m} will remain
     * as {@code getPlaceHolder()+m}, where {@code m} is an {@code int >= args.length}.
     * <p>
     * If {@code args} has too many elements, then the method completes normally.
     * @param rv The source string.
     * @param args The objects that replace {@code getPlaceHolder()+n}, where {@code n} is the index
     * of {@code args}.
     * @return The modified string.
     * @see #withArgs(Object...)
     * @see #withArgs(String, String, Object...)
     */
    static String withArgs(String rv, Object... args){
        return withArgs(rv, getPlaceHolder(), args);
    }

    /**
     * Replaces every occurrence of {@code placeHolder+n} in the string {@code rv},
     * where {@code n} represents the index of args.
     * <p>
     * If {@code args} doesn't have enough elements, then the {@code placeHolder+m} will remain
     * as {@code placeHolder+m}, where {@code m} is an {@code int >= args.length}.
     * <p>
     * If {@code args} has too many elements, then the method completes normally.
     * @param rv The source string.
     * @param args The objects that replace {@code placeHolder+n}, where {@code n} is the index
     * of {@code args}.
     * @return The modified string.
     * @see #withArgs(Object...)
     * @see #withArgs(String, Object...)
     */
    static String withArgs(String rv, String placeHolder, Object... args){
        for (int i = 0; i < args.length; i++) {
            rv = rv.replaceAll(placeHolder+i,args[i].toString());
        }
        return rv;
    }

    /**
     * Used as the default placeHolder, if no special placeHolder is given.
     * @return {@code "ARG"}, if not overridden.
     * @see #withArgs(Object...)
     * @see #withArgs(String, Object...)
     */
    static String getPlaceHolder(){
        return "ARG";
    }

    /**
     * Convenience method. Appends {@code n} to {@code getPlaceHolder()}.
     * @param n The number to be appended.
     * @return The modified placeHolder string.
     * @see #getPlaceHolder()
     */
    static String makeArg(int n){
        return getPlaceHolder() + n;
    }


}
