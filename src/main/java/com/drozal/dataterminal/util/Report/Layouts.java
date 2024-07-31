package com.drozal.dataterminal.util.Report;

import com.drozal.dataterminal.util.Report.nestedReportUtils.*;

import java.util.Map;

import static com.drozal.dataterminal.util.Report.reportUtil.createReportWindow;

public class Layouts {
	public static Map<String, Object> trafficStopLayout() {
		Map<String, Object> trafficStopReport = createReportWindow("Traffic Stop Report", 6, 8, new TransferConfig(
				                                                           "Transfer Information To New Report",
				                                                           new RowConfig(new FieldConfig("transferarrestbtn", 6, FieldType.TRANSFER_BUTTON),
				                                                                         new FieldConfig("transfercitationbtn", 6, FieldType.TRANSFER_BUTTON))),
		                                                           new SectionConfig("Officer Information", true,
		                                                                             new RowConfig(
				                                                                             new FieldConfig("name", 5,
				                                                                                             FieldType.TEXT_FIELD),
				                                                                             new FieldConfig("rank", 5,
				                                                                                             FieldType.TEXT_FIELD),
				                                                                             new FieldConfig("number",
				                                                                                             2,
				                                                                                             FieldType.TEXT_FIELD)),
		                                                                             new RowConfig(
				                                                                             new FieldConfig("division",
				                                                                                             6,
				                                                                                             FieldType.TEXT_FIELD),
				                                                                             new FieldConfig("agency",
				                                                                                             6,
				                                                                                             FieldType.TEXT_FIELD))),
		                                                           new SectionConfig("Location / Timestamp Information",
		                                                                             true, new RowConfig(
				                                                           new FieldConfig("street", 4,
				                                                                           FieldType.TEXT_FIELD),
				                                                           new FieldConfig("area", 4,
				                                                                           FieldType.COMBO_BOX_AREA),
				                                                           new FieldConfig("county", 4,
				                                                                           FieldType.TEXT_FIELD)),
		                                                                             new RowConfig(
				                                                                             new FieldConfig("date", 5,
				                                                                                             FieldType.TEXT_FIELD),
				                                                                             new FieldConfig("time", 5,
				                                                                                             FieldType.TEXT_FIELD),
				                                                                             new FieldConfig(
						                                                                             "stop number", 2,
						                                                                             FieldType.TEXT_FIELD))),
		                                                           new SectionConfig("Offender Information", true,
		                                                                             new RowConfig(new FieldConfig(
				                                                                             "offender name", 4,
				                                                                             FieldType.TEXT_FIELD),
		                                                                                           new FieldConfig(
				                                                                                           "offender age",
				                                                                                           4,
				                                                                                           FieldType.TEXT_FIELD),
		                                                                                           new FieldConfig(
				                                                                                           "offender gender",
				                                                                                           4,
				                                                                                           FieldType.TEXT_FIELD)),
		                                                                             new RowConfig(new FieldConfig(
				                                                                             "offender address", 6,
				                                                                             FieldType.TEXT_FIELD),
		                                                                                           new FieldConfig(
				                                                                                           "offender description",
				                                                                                           6,
				                                                                                           FieldType.TEXT_FIELD))),
		                                                           new SectionConfig("Offender Vehicle Information",
		                                                                             true, new RowConfig(
				                                                           new FieldConfig("model", 4,
				                                                                           FieldType.TEXT_FIELD),
				                                                           new FieldConfig("plate number", 4,
				                                                                           FieldType.TEXT_FIELD),
				                                                           new FieldConfig("color", 4,
				                                                                           FieldType.COMBO_BOX_COLOR)),
		                                                                             new RowConfig(
				                                                                             new FieldConfig("type", 4,
				                                                                                             FieldType.COMBO_BOX_TYPE),
				                                                                             new FieldConfig(
						                                                                             "other info", 8,
						                                                                             FieldType.TEXT_FIELD))),
		                                                           new SectionConfig("Comments", true, new RowConfig(
				                                                           new FieldConfig("notes", 12,
				                                                                           FieldType.TEXT_AREA))));
		return trafficStopReport;
	}
	
}
