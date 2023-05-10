<!--
 ___ _            _ _    _ _    __
/ __(_)_ __  _ __| (_)__(_) |_ /_/
\__ \ | '  \| '_ \ | / _| |  _/ -_)
|___/_|_|_|_| .__/_|_\__|_|\__\___|
            |_| 
-->
![](https://docs.simplicite.io//logos/logo250.png)
* * *

In Simplicité, there are a number of things that are part of the configuration but that some advanced users or admins sometimes want to have the ability to update independently, either during the app's specification phase or during its normal life, in particular:
- lists (enums)
- translations (fields, actions, objects, etc,)

This module allows the users to make updates. Let's see how it works, but please **be warned that this module comes with no warranties, so it is your responsibility to understand it, test it and modify it if necessary**.

How it works
---------------------------

The general idea is that this module is installed on a staging or production environement, and a process is put in place for the developers to periodically retrieve and apply the modifications on the dev environement. **If the process is not respected, the modifications will be overwritten by the deployements** ⚠️

1. configure **which modules the users can modify** in the `MDF_MODULES` system parameter *(for example **MyApp1, MyApp2**)*
2. give the `MDF_ADMIN` responsibility to the user or group that can make updates. Those users will get access to a Modificator Domain (and scope).
3. through those menus, users search for the item and update it.  After they do that, a warning message is presented to them to notify the developement team.
4. When updated, **the configuration item is moved from your app's module (for example MyApp1) to the MdfModifications module**! A developer must integrate the modifications in the app's configuration:
     - export the MdfModifications module as a single XML file
     - in the XML file, remove the first XML `<object>` block *(it's the MdfModifications module, you don't need it)*
     - search & replace all `MdfModifications` instances and replace them by you module's name (for example `MyApp1`)
    - import the resulting XML on your dev instance (that will effetively apply the modifications made by the user on your dev instance)
   - commit the changes, you're done and can now deploy!