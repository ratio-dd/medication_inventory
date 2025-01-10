
# DataBase design

![Diagram](https://raw.githubusercontent.com/ratio-dd/medication_inventory/main/design_UML/first_design/first_design.svg)

## medication table
- med_id: PK,show unique ID of each medication
- product_name: This name is named by factory, like *Tylenol Extra Strength*
- generic_name: This name represent active part of medicine
- common_name: How user call the medicine
- manufacturer: as the name
- purchase_method: where do user buy the medication
- specification: in which specification of a minimal size? *e.g. 50 pill per box*
- dose: how many ml/mg per pill
- formulation: what type of medicine.*e.g.Tablet, Capsule, Syrup, Patch*
- place_of_origin: Key is to store whether is domestic or imported
- effects: as name
- manufacture_date: date type
- expiry_date: expiry date. **Important column**
- barcode: Product barcode
- trace_code: for safety trace back usage
- batch_number: optional column
- memo

## inventory
- inventory_id: unique id for each inventory data
- med_id: Foreign key from medication table. 1 to 1
- remaining_quantity: quantity count in minimal unit. e.g. 50 tablet
- location: as name. May have a unique location *Fridge*
- unit_type: don't have idea of whether I use this column or not. Need further design

## med_schedule
- schedule_id: PK
- user_id: FK with user table
- med_id: FK with medication table
- dosage: in minimal unit. May have float(have pill)
- time_of_day: non-accurate time, such as "before breakfast", "before bed"
- memo

## user
- user_id: PK
- name
- age
- gender
- memo
- [ ] Further may have user's illness for better user profile

## med_intake_status
- intake_id: PK
- schedule_id: FK with schedule table
- user_id: FK with user table
- time: accurate time. Update with user/auto function
- status: penning, finished, missed may show in different color in user interface
- memo
